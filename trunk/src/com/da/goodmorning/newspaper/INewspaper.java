package com.da.goodmorning.newspaper;

public interface INewspaper {
	public NewspaperProperties newspaperProps = new NewspaperProperties();
	
	void notifyDataSetChanged();
	
	public NewspaperProperties getNewspaperProps();
}
