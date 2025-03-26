public enum App1 {
    
    RED, GREEN, BLUE;

    // Beispielmethode
    public String getColorCode() {
        switch (this) {
            case RED:
                return "#FF0000";
            case GREEN:
                return "#00FF00";
            case BLUE:
                return "#0000FF";
            default:
                return "#000000";
        }
    }
}
