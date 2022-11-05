public enum RepeatabilityTask {
    ONE_TIME("One time"),
    EVERY_DAY("Every Day"),
    EVERY_WEEK("Every week"),
    EVERY_MONTH("Every month"),
    EVERY_YEAR("Every year");

    private String type;
     RepeatabilityTask(String type) {
        this.type = type;
    }
}
