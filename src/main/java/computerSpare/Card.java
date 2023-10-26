package computerSpare;

public class Card {
	
	
	private int idcard;
	private String CardNumber;
	private String CardHolderName;
	private String CVC;
	private String ExpiredDate;
	
	public Card(int idcard, String CardNumber, String CardHolderName, String CVC, String ExpiredDate)
	{
		this.idcard = idcard;
		this.CardNumber = CardNumber;
		this.CardHolderName = CardHolderName;
		this.CVC = CVC;
		this.ExpiredDate = ExpiredDate;
	}

	public int getIdcard() {
		return idcard;
	}

	

	public String getCardNumber() {
		return CardNumber;
	}

	
	public String getCardHolderName() {
		return CardHolderName;
	}

	

	public String getCVC() {
		return CVC;
	}

	

	public String getExpiredDate() {
		return ExpiredDate;
	}

	


}
