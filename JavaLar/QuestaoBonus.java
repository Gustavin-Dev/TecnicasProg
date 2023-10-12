package JavaLar;

import java.util.ArrayList;

public class QuestaoBonus {
	
	public double QuestaoExtra(ArrayList<Planetas> planetas) {
		int soma1=0;
		int soma2=0;
		double area=0;
		for (int i = 0; i < planetas.size(); i++) {
			if(i < (planetas.size()-1)){
			soma1 += (planetas.get(i).posicaoX * planetas.get(i+1).posicaoY);
			soma2 += (planetas.get(i).posicaoY * planetas.get(i+1).posicaoX);
			}else {
				soma1 += (planetas.get(i).posicaoX * planetas.get(0).posicaoY);
				soma2 += (planetas.get(i).posicaoY * planetas.get(0).posicaoX);
			}
		}
		area = Math.abs(0.5*(soma1 - soma2));
		
		return area;
		
		
	}
	

}
