package team08

class MonyService {
	MemberCustomer customer
	Employee employee
	String 	cradit
	String	priceroom
    static constraints = {
     	priceroom nullable:true
		cradit nullable:true
    }
}
