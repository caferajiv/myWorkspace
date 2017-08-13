package threads.producerconsumer;

import java.util.List;

public class Operator {
	
	List <Commodity> commodityList;
	
	public Operator(){
		
	}
	
	public Operator(List<Commodity> commodityList){
		this.commodityList=commodityList;
	}
	
	public void addCommodityToList(Commodity commodity){
		while(true){
			synchronized(commodityList){
				commodityList.add(commodity);
				commodityList.notifyAll();
			}
		}
	}

	
	public void removeCommodityFromList(){
		while(true){
			synchronized(commodityList){
				while(commodityList.size()==0){
					try {
						commodityList.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				commodityList.remove(0);
				commodityList.notifyAll();
			}
			
		}
	}
}
