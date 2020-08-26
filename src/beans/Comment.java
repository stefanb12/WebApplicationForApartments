package beans;

public class Comment {
	Guest guest; // Gost koji je ostavio komentar
	Apartment apartment; // Apartman na koji se odnosi komentar
	String content; // Tekst komentara
	int mark; // Ocena

	public Comment () {
		
	}

	public Comment(Guest guest, Apartment apartment, String content, int mark) {
		super();
		this.guest = guest;
		this.apartment = apartment;
		this.content = content;
		this.mark = mark;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
		
}
