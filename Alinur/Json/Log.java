public class Log {
    String eventId;
    String eventType;
    String eventName;
    String requestId;
    String requestName;
    String requestMethod;
    String parentRequestId;
    String userId;
    String accountName;
    String accountID;
    String childRequestIds;
    String error;
    Payload payload;
    String dbWrites;
    String dbReads;
    long startTime;
    long endTime;
    TimeMillis timeMillis;
    DurationMillis durationMillis;
    String totalDurationMillis;
    StrFields strFields;
    NumFields numFields;
    String doubleFields;
    String boolFields;
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
        public void setEventType(String eventType){
            this.eventType = eventType;
        }
        public void setEventName(String eventName){
            this.eventName = eventName;
        }
        public void setRequestId(String requestId){
            this.requestId = requestId;
        }
        public void setAccountID(String accountID) {
            this.accountID = accountID;
        }
        public void setRequestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
        }
        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }
        public void setRequestName(String requestName) {
            this.requestName = requestName;
        }
        public void setParentRequestId(String parentRequestId){
            this.parentRequestId = parentRequestId;
        }
        public void setUserId(String userId) {
            this.userId = userId;
        }
        public void setChildRequestIds(String childRequestIds) {
            this.childRequestIds = childRequestIds;
        }
        public void setDbReads(String dbReads) {
            this.dbReads = dbReads;
        }
        public void setError(String error) {
            this.error = error;
        }
        public void setTotalDurationMillis(String totalDurationMillis) {
            this.totalDurationMillis = totalDurationMillis;
        }
        public void setDbWrites(String dbWrites) {
            this.dbWrites = dbWrites;
        }
        public void setBoolFields(String boolFields) {
            this.boolFields = boolFields;
        }
        public void setDoubleFields(String doubleFields) {
            this.doubleFields = doubleFields;
        }
        public void setDurationMillis(DurationMillis durationMillis) {
            this.durationMillis = durationMillis;
        }
        public void setPayload(Payload payload) {
            this.payload = payload;

        }
        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }
        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }
        public void setTimeMillis(TimeMillis timeMillis) {
            this.timeMillis = timeMillis;
        }
        public void setNumFields(NumFields numFields) {
            this.numFields = numFields;
        }
        public void setStrFields(StrFields strFields) {
            this.strFields = strFields;
        }
}
