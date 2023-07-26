package application.model;


public class CustomModel {
	private int idCustom;
	private String codeCus;
	private String firstNameCus;//ho
	private String lastNameCus;//ten
	private String addressCus;
	private String emailCus;
	private String nameTrade;
	private String numberPhoneCus;
	private String numAccBank;
	private String nameAccBank;
	private String faxCus;
	
	private String hoten;
	
	public CustomModel(int idCustom, String codeCus, String firstNameCus, String lastNameCus, String addressCus,
			String emailCus, String nameTrade, String numberPhoneCus, String numAccBank, String nameAccBank,
			String faxCus) {
		super();
		this.idCustom = idCustom;
		this.codeCus = codeCus;
		this.firstNameCus = firstNameCus;
		this.lastNameCus = lastNameCus;
		this.addressCus = addressCus;
		this.emailCus = emailCus;
		this.nameTrade = nameTrade;
		this.numberPhoneCus = numberPhoneCus;
		this.numAccBank = numAccBank;
		this.nameAccBank = nameAccBank;
		this.faxCus = faxCus;
	}

	public CustomModel(String codeCus, String firstNameCus, String lastNameCus, String addressCus, String emailCus,
			String nameTrade, String numberPhoneCus, String numAccBank, String nameAccBank, String faxCus) {
		super();
		this.codeCus = codeCus;
		this.firstNameCus = firstNameCus;
		this.lastNameCus = lastNameCus;
		this.addressCus = addressCus;
		this.emailCus = emailCus;
		this.nameTrade = nameTrade;
		this.numberPhoneCus = numberPhoneCus;
		this.numAccBank = numAccBank;
		this.nameAccBank = nameAccBank;
		this.faxCus = faxCus;
	}
	
	
	
	public String getHoten() {
		String hoten = firstNameCus +" "+lastNameCus ;
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getIdCustom() {
		return idCustom;
	}

	public void setIdCustom(int idCustom) {
		this.idCustom = idCustom;
	}

	public String getCodeCus() {
		return codeCus;
	}

	public void setCodeCus(String codeCus) {
		this.codeCus = codeCus;
	}

	public String getFirstNameCus() {
		return firstNameCus;
	}

	public void setFirstNameCus(String firstNameCus) {
		this.firstNameCus = firstNameCus;
	}

	public String getLastNameCus() {
		return lastNameCus;
	}

	public void setLastNameCus(String lastNameCus) {
		this.lastNameCus = lastNameCus;
	}

	public String getAddressCus() {
		return addressCus;
	}

	public void setAddressCus(String addressCus) {
		this.addressCus = addressCus;
	}

	public String getEmailCus() {
		return emailCus;
	}

	public void setEmailCus(String emailCus) {
		this.emailCus = emailCus;
	}

	public String getNameTrade() {
		return nameTrade;
	}

	public void setNameTrade(String nameTrade) {
		this.nameTrade = nameTrade;
	}

	public String getNumberPhoneCus() {
		return numberPhoneCus;
	}

	public void setNumberPhoneCus(String numberPhoneCus) {
		this.numberPhoneCus = numberPhoneCus;
	}

	public String getNumAccBank() {
		return numAccBank;
	}

	public void setNumAccBank(String numAccBank) {
		this.numAccBank = numAccBank;
	}

	public String getNameAccBank() {
		return nameAccBank;
	}

	public void setNameAccBank(String nameAccBank) {
		this.nameAccBank = nameAccBank;
	}

	public String getFaxCus() {
		return faxCus;
	}

	public void setFaxCus(String faxCus) {
		this.faxCus = faxCus;
	}
	
	
	
}
