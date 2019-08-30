import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CookThread implements Runnable {
	private BlockingQueue<Food> serverQueue;
	private List<Food> foodList;

	public CookThread(List<Food> foodList, BlockingQueue<Food> serverQueue) {
		this.foodList = foodList;
		this.serverQueue = serverQueue;
	}

	@Override
	public void run() {
		try {
			for (Food food : foodList) {
				System.out.println("COOK READY");
				System.out.println("COOK STARTING: " + food.toString());
				Thread.sleep(food.getCookTime() * 1000);
				serverQueue.put(food);
				System.out.println("COOK ENDING: " + food.toString());
			}
		} catch (InterruptedException ex) {

		}
	}

}
