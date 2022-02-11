package demo;

import java.util.ArrayList;
import java.util.Random;
import common.Game;
import common.Machine;

public class Game_0015 extends Game {

	@Override
	public void addMachines(ArrayList<Machine> machines, int numFaulty) {
		// TODO Auto-generated method stub
		myMachines.addAll(machines);
		for(int i=0;i<myMachines.size();i++)
		{
			myMachines.get(i).setMachines(machines);
		}
		this.numFaulty = numFaulty;	
	}

	@Override
	public void startPhase() {
		// TODO Auto-generated method stub
		int leader = random.nextInt(myMachines.size());
		myMachines.get(leader).setLeader();
		for(int i=0;i<myMachines.size()-numFaulty;i++)
		{
			myMachines.get(i).setState(true);
		}
		for(int i=myMachines.size()-numFaulty;i<myMachines.size();i++)
		{
			myMachines.get(i).setState(false);
		}
	}
	private ArrayList<Machine> myMachines = new ArrayList<Machine>();
	private Random random = new Random();
	private int numFaulty;
}
