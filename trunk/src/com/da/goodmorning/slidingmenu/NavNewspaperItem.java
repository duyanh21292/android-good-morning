package com.da.goodmorning.slidingmenu;

public class NavNewspaperItem {
	
	private int type = 0;
	private String title = "";
    private int icon = 0;
    private String count = "0";
    private boolean isCounterVisible = false;
    private boolean isSelected = false;
     
    public NavNewspaperItem(){
    	
    }
 
    public NavNewspaperItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }
     
    public NavNewspaperItem(int type, String title, int icon, String count,
			boolean isCounterVisible) {
		super();
		this.type = type;
		this.title = title;
		this.icon = icon;
		this.count = count;
		this.isCounterVisible = isCounterVisible;
	}
    

	public NavNewspaperItem(int type, String title, int icon, String count,
			boolean isCounterVisible, boolean isSelected) {
		super();
		this.type = type;
		this.title = title;
		this.icon = icon;
		this.count = count;
		this.isCounterVisible = isCounterVisible;
		this.isSelected = isSelected;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public boolean isCounterVisible() {
		return isCounterVisible;
	}

	public void setCounterVisible(boolean isCounterVisible) {
		this.isCounterVisible = isCounterVisible;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle(){
        return this.title;
    }
     
    public int getIcon(){
        return this.icon;
    }
     
    public String getCount(){
        return this.count;
    }
     
    public boolean getCounterVisibility(){
        return this.isCounterVisible;
    }
     
    public void setTitle(String title){
        this.title = title;
    }
     
    public void setIcon(int icon){
        this.icon = icon;
    }
     
    public void setCount(String count){
        this.count = count;
    }
     
    public void setCounterVisibility(boolean isCounterVisible){
        this.isCounterVisible = isCounterVisible;
    }
}
