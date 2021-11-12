import lombok.*;

public class Payload {
    String jobSize;
    String status;
    String currentIndex;
    String nextIndex;
    String retryIndex;
    String maxIndex;
    String uploadSpeed;
    String remaining;
    String elapsed;
    String currentItem;
    String completed;
    String ended;
    String aborted;
    String errorMessage;
    String totalUnits;
    String jobId;

    public void setAborted(String aborted) {
        this.aborted = aborted;
    }

    public void setCurrentIndex(String currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void setJobSize(String jobSize) {
        this.jobSize = jobSize;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMaxIndex(String maxIndex) {
        this.maxIndex = maxIndex;
    }

    public void setNextIndex(String nextIndex) {
        this.nextIndex = nextIndex;
    }

    public void setRetryIndex(String retryIndex) {
        this.retryIndex = retryIndex;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public void setUploadSpeed(String uploadSpeed) {
        this.uploadSpeed = uploadSpeed;
    }

    public void setCurrentItem(String currentItem) {
        this.currentItem = currentItem;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setTotalUnits(String totalUnits) {
        this.totalUnits = totalUnits;
    }
}

