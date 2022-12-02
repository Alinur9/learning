package com.xyz.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.xyz.shared.MatchForVoting;


import java.util.ArrayList;

public class WinnerTeamUi implements IsWidget {

    private final GreetingServiceAsync service;
    Box box2 = new Box();
    Button cancel = new Button("cancel");
    Button logOut = new Button("Log out");

    private ClickHandler goToMatchListUi;
    private ClickHandler goToTopBar;

    public WinnerTeamUi(GreetingServiceAsync greetingServiceAsync){
        this.service = greetingServiceAsync;

        box2.setStyleName("match-ui");
        box2.getElement().setAttribute("style", " padding: 30px; border: 1px solid #ddd; box-shadow: .5px 1px 5px #00FFFF");
        cancel.setStyleName("cancel-sub-btn");
        logOut.setStyleName("cancel-sub-btn");
        box2.add(cancel);
        box2.add(logOut);

        cancel.addClickHandler(this::goToMatchListUi);
        logOut.addClickHandler(this::goToTopBar);


        CellTable<MatchForVoting> table = new CellTable<MatchForVoting>();
        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        box2.add(table);

        TextColumn<MatchForVoting> matchId = new TextColumn<MatchForVoting>() {
            @Override
            public String getValue(MatchForVoting object) {
                return String.valueOf(object.getMatchID());
            }
        };
        table.addColumn(matchId, "Match ID");
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
        TextColumn<MatchForVoting> game = new TextColumn<MatchForVoting>() {
            @Override
            public String getValue(MatchForVoting object) {
                return object.getGame();
            }
        };
        table.addColumn(game, "Game");
        TextColumn<MatchForVoting> winnerTeam = new TextColumn<MatchForVoting>() {
            @Override
            public String getValue(MatchForVoting object) {
                return object.getTeam1();
            }
        };
        table.addColumn(winnerTeam, "Winner Team");
        TextColumn<MatchForVoting> result = new TextColumn<MatchForVoting>() {
            @Override
            public String getValue(MatchForVoting object) {
                return object.getResult();
            }
        };
        table.addColumn(result, "Result");

        service.getUsersWinnerTeam(new AsyncCallback<ArrayList<MatchForVoting>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("server error on winnerUi");
            }
            @Override
            public void onSuccess(ArrayList<MatchForVoting> matchForVotings) {
                table.setRowCount(matchForVotings.size(), true);
                table.setRowData(0, matchForVotings);
            }
        });
    }
    private void goToMatchListUi(ClickEvent clickEvent){
        if (goToMatchListUi != null){
            goToMatchListUi.onClick(clickEvent);
        }
    }
    private void goToTopBar(ClickEvent clickEvent){
        if (goToTopBar != null){
            goToTopBar.onClick(clickEvent);
        }
    }
    public void addSwitchToLogoutHandler(ClickHandler handler){
        this.goToTopBar = handler;
    }
    public void addSwitchToMatchListUi(ClickHandler handler ) {
        this.goToMatchListUi = handler;
    }
    @Override
    public Widget asWidget() {
        return box2;
    }


}
