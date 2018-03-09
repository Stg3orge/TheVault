public class Keyboard {
    
    private String model;
    private boolean isWireless;
    private String language;
    
    public Keyboard(String model, boolean isWireless, String language) {
        this.model = model;
        this.isWireless = isWireless;
        this.language = language;
    }
    
    public String getModel(){
        return model;
    }
    
    public void setModel(String _model){
        model = _model;
    }
    
    public boolean getIsWireless(){
        return isWireless;
    }
    
    public void setIsWireless(boolean _isWireless){
        isWireless = _isWireless;
    }
    
    public String getLanguage(){
        return language;
    }
    
    public void setLanguage(String _language){
        language = _language;
    }
    
    public String shortLanguage(){
        return language.substring(0,2);
    }
    
    public void Print(){
        String newLine = System.getProperty("line.separator");
        
        System.out.println("Details of Keyboard" + newLine + newLine
        + "Model series: " + model + newLine + "Wireless: " + isWireless
        + newLine + "Language: " + language + "/" + shortLanguage());
    }
}
