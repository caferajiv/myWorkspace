/**
 * 
 */
package com.loadcontrol.observers;

/**
 * @author Illuminati
 *
 */
public interface IResourceOverloadObserver extends IResourceObserver{
	
	public void performActionOnOverloadEvent();
	
	public void performActionOnOverloadRectificationEvent();

}
