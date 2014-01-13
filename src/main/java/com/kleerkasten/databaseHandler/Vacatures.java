package databaseStructure;

import java.util.ArrayList;

public class Vacatures {
	private ArrayList<Integer> Vacature_ID,urenperweek;
	private ArrayList<String> title,opleidingniveau,text,vakgebied,soortbaan,samenvatting,link,datum;
	public Vacatures(){
		Vacature_ID=new ArrayList<Integer>();
		urenperweek=new ArrayList<Integer>();
		title=new ArrayList<>();
		opleidingniveau=new ArrayList<>();
		text=new ArrayList<>();
		vakgebied=new ArrayList<>();
		soortbaan=new ArrayList<>();
		samenvatting=new ArrayList<>();
		link=new ArrayList<>();
		datum=new ArrayList<>();	
	}
	public void addItems(int Vacature_ID,int urenperweek,String title,String opleidingniveau,String text,String vakgebied,String soortbaan,String samenvatting,String link,String datum){
		try{
		this.Vacature_ID.add(Vacature_ID);
		this.urenperweek.add(urenperweek);
		this.title.add(title);
		this.opleidingniveau.add(opleidingniveau);
		this.text.add(text);
		this.vakgebied.add(vakgebied);
		this.soortbaan.add(soortbaan);
		this.samenvatting.add(samenvatting);
		this.link.add(link);
		this.datum.add(datum);
		}
		catch(Exception e){
			//e.printStackTrace();
		}
	}

	public ArrayList<Integer> getVacature_ID() {
		return Vacature_ID;
	}

	public ArrayList<Integer> getUrenperweek() {
		return urenperweek;
	}

	public ArrayList<String> getTitle() {
		return title;
	}

	public ArrayList<String> getOpleidingniveau() {
		return opleidingniveau;
	}

	public ArrayList<String> getText() {
		return text;
	}

	public ArrayList<String> getVakgebied() {
		return vakgebied;
	}

	public ArrayList<String> getSoortbaan() {
		return soortbaan;
	}

	public ArrayList<String> getSamenvatting() {
		return samenvatting;
	}

	public ArrayList<String> getLink() {
		return link;
	}

	public ArrayList<String> getDatum() {
		return datum;
	}

}
