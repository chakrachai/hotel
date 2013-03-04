package team08

class MonyService {
	MemberCustomer customer
	Employee employee
	String	dateIn
	String	dateOut
	String 	cradit
	String 	money
	String	priceroom 
    static constraints = {
		customer nullable:true
		employee nullable:true
     	priceroom nullable:true
		cradit nullable:true
		money nullable:true
		dateIn nullable:true
		dateOut nullable:true
    }
}
