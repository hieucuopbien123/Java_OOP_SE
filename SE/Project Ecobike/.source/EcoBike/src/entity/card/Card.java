package entity.card;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import entity.db.AIMSDB;
import utils.Utils;

public class Card {
    private static Logger LOGGER = Utils.getLogger(Card.class.getName());
    
    public Card(String cardholder_name, String card_number, Date expiration_date, String issuing_bank, String security_code, int cvvCode) {
    	this.card_number = card_number;
    	this.cardholder_name = cardholder_name;
    	this.expiration_date = expiration_date;
    	this.issuing_bank = issuing_bank;
    	this.security_code = security_code;
    	this.cvvCode = cvvCode;
    }
    
    String card_number;
    String cardholder_name;
    Date expiration_date;
    String issuing_bank;
    String security_code;
    int cvvCode;

    public int getCvvCode() {
    	return cvvCode;
    }
    public void setCvvCode(int cvvCode) {
    	this.cvvCode = cvvCode;
    }
	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCardholder_name() {
		return cardholder_name;
	}

	public void setCardholder_name(String cardholder_name) {
		this.cardholder_name = cardholder_name;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getIssuing_bank() {
		return issuing_bank;
	}

	public void setIssuing_bank(String issuing_bank) {
		this.issuing_bank = issuing_bank;
	}

	public String getSecurity_code() {
		return security_code;
	}

	public void setSecurity_code(String security_code) {
		this.security_code = security_code;
	}
}
