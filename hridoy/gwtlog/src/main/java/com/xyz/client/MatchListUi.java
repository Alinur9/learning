package com.xyz.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.xyz.shared.MatchForVoting;
import com.xyz.shared.VotingRequest;
import com.xyz.shared.VotingResponse;

import java.util.ArrayList;

public class MatchListUi implements IsWidget {
    private final GreetingServiceAsync service;

    private ClickHandler goToTopBar;
    private ClickHandler goToWinner;

    Box box2 = new Box();


    TextArea textArea1 = new TextArea();
    ListBox winnerTeam = new ListBox();
    TextField matchID = new TextField("match id", "");
    Button logOut = new Button("log out");
    Button submit = new Button("submit");
    Button buttonWinnerTeam = new Button("Winner Team");

    VotingRequest votingRequest = new VotingRequest();



    public MatchListUi(GreetingServiceAsync service) {
        this.service = service;
        box2.setStyleName("match-ui");
        box2.getElement().setAttribute("style", " padding: 30px; border: 1px solid #ddd; box-shadow: .5px 1px 5px #00FFFF");
        logOut.setStyleName("cancel-sub-btn");
        submit.setStyleName("cancel-sub-btn");

        CellTable<MatchForVoting> table = new CellTable<MatchForVoting>();
        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);



        TextColumn<MatchForVoting> matchId = new TextColumn<MatchForVoting>() {
                    @Override
                    public String getValue(MatchForVoting object) {
                        return String.valueOf(object.getMatchID());
                    }
                };
        table.addColumn(matchId, "Match ID");

        TextColumn<MatchForVoting> gameType = new TextColumn<MatchForVoting>() {
                    @Override
                    public String getValue(MatchForVoting object) {
                        return object.getGameType();
                    }
                };
        table.addColumn(gameType, "Game Type");

        TextColumn<MatchForVoting> groupStage = new TextColumn<MatchForVoting>() {
                    @Override
                    public String getValue(MatchForVoting object) {
                        return object.getGroupStage();
                    }
                };
        table.addColumn(groupStage, "Group Stage");

        TextColumn<MatchForVoting> matchTime = new TextColumn<MatchForVoting>() {
            @Override
            public String getValue(MatchForVoting object) {
                return object.getMatchTime();
            }
        };
        table.addColumn(matchTime, "Match Time");

        TextColumn<MatchForVoting> team1 = new TextColumn<MatchForVoting>() {
                    @Override
                    public String getValue(MatchForVoting object) {
                        return object.getTeam1();
                    }
                };
        table.addColumn(team1, "Team-1");

        TextColumn<MatchForVoting> team2 = new TextColumn<MatchForVoting>() {
                    @Override
                    public String getValue(MatchForVoting object) {
                        return object.getTeam2();
                    }
                };
        table.addColumn(team2, "Team-2");

        TextColumn<MatchForVoting> venue = new TextColumn<MatchForVoting>() {
                    @Override
                    public String getValue(MatchForVoting object) {
                        return object.getVenue();
                    }
                };
        table.addColumn(venue, "Venue");

        TextColumn<MatchForVoting> result = new TextColumn<MatchForVoting>() {
                    @Override
                    public String getValue(MatchForVoting object) {
                        return object.getResult();
                    }
                };
        table.addColumn(result, "Result");

        final SingleSelectionModel<MatchForVoting> selectionModel
                = new SingleSelectionModel<MatchForVoting>();
        table.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(
                new SelectionChangeEvent.Handler() {
                    public void onSelectionChange(SelectionChangeEvent event) {
                        MatchForVoting selected = selectionModel.getSelectedObject();
                        if (selected != null) {
                            matchID.setText(String.valueOf(selected.getMatchID()));
                            winnerTeam.clear();
                            winnerTeam.addItem("Select winner " + selected.team1 + " vs " + selected.team2,"");
                            winnerTeam.addItem(selected.getTeam1());
                            winnerTeam.addItem(selected.getTeam2());


                            votingRequest.gameType = selected.getGameType();
                            votingRequest.team1 = selected.getTeam1();
                            votingRequest.team2 = selected.getTeam2();
                            votingRequest.groupStage = selected.getGroupStage();


                        }else {
                            matchID.setText(null);
                        }
                    }
                });


        ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.setHeight("400px");
        scrollPanel.add(table);
        matchID.asWidget().setVisible(false);
        box2.add(textArea1);
        box2.add(winnerTeam);
        box2.add(submit);
        box2.add(logOut);
        box2.add(buttonWinnerTeam);
        box2.add(scrollPanel);




        submit.addClickHandler(this::updatingYourVote );
        logOut.addClickHandler(this::goToTopBar);
        buttonWinnerTeam.addClickHandler(this::goToWinner);





        service.getMatchesForVoting(new AsyncCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                textArea1.setText("server error");
            }
            @Override
            public void onSuccess(ArrayList<MatchForVoting> matchForVotings) {
                table.setRowCount(matchForVotings.size(), true);
                table.setRowData(0, matchForVotings);


            }
        });


    }

    private void updatingYourVote(ClickEvent clickEvent){
        if (winnerTeam.getSelectedIndex() == 0 || matchID.getText() == null){
            Window.alert("please select a winner before voting");
            return;
        }
        votingRequest.matchID = Integer.parseInt(matchID.getText());
        votingRequest.selectedTeam = winnerTeam.getSelectedItemText();
        service.votedTeam(votingRequest, new AsyncCallback<VotingResponse>() {
            @Override
            public void onFailure(Throwable throwable) {
                textArea1.setText("server error");
            }
            @Override
            public void onSuccess(VotingResponse votingResponse) {
                if (votingResponse.successful){
                    if (goToWinner != null){
                        goToWinner.onClick(clickEvent);
                    }
                }else {
                    Window.alert(votingResponse.errorMsg);
                }
            }
        });
    }


    private void goToTopBar(ClickEvent clickEvent){

        if (goToTopBar != null){
            goToTopBar.onClick(clickEvent);
        }
    }
    private void goToWinner(ClickEvent clickEvent){

        if (goToWinner != null){
            goToWinner.onClick(clickEvent);
        }
    }
    public void addSwitchToWinnerHandler(ClickHandler handler){
        this.goToWinner = handler;
    }
    public void addSwitchToLogoutHandler(ClickHandler handler){
        this.goToTopBar = handler;
    }




    @Override
    public Widget asWidget() {
        return box2;
    }
}
