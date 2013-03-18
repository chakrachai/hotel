package team08



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(MemberCustomer)
class MemberCustomerTests {

    void testMember() {
       def s = new MemberCustomer(fName:"GiiZBrelliEN",mName:"Meteora",lName:"Hybrid",
       	gender:"Mail",born:"2000/12/1",age:"19",nationality:"Thai",
       	idCityzen:"1109900784877",address:"Nakhonratchima",
       	emailAddress:"giizbrellien@gmail.com",memberId:"UltimateBoss",
       	memberType:"VIP MEMBER",telNo:"0882329929") 

       assert s.fName == "GiiZBrelliEN"
       assert s.mName == "Meteora"
       assert s.lName == "Hybrid"
       assert s.gender == "Mail"
       assert s.born == "2000/12/1"
       assert s.age == "19"
       assert s.nationality == "Thai"
       assert s.address == "Nakhonratchima"
       assert s.emailAddress == "giizbrellien@gmail.com"
       assert s.memberId == "UltimateBoss"
       assert s.memberType == "VIP MEMBER"
       assert s.telNo == "0882329929"
       assert s.idCityzen == "1109900784877"
       assert s.validate() == true
    }

    void testIdCityzenNotNull(){
	    def s = new MemberCustomer(fName:"GiiZBrelliEN",mName:"Meteora",lName:"Hybrid",
	       	gender:"Mail",born:"2000/12/1",age:"19",nationality:"Thai",
	       	idCityzen:"",address:"Nakhonratchima",
	       	emailAddress:"giizbrellien@gmail.com",memberId:"UltimateBoss",
	       	memberType:"VIP MEMBER",telNo:"0882329929") 
	    assert s.validate() == false
    }
    void testIdCityzenNummericOnlyAnd13(){

		def s = new MemberCustomer(fName:"GiiZBrelliEN",mName:"Meteora",lName:"Hybrid",
	       	gender:"Mail",born:"2000/12/1",age:"19",nationality:"Thai",
	       	idCityzen:"1tq45w789098q",address:"Nakhonratchima",
	       	emailAddress:"giizbrellien@gmail.com",memberId:"UltimateBoss",
	       	memberType:"VIP MEMBER",telNo:"0882329929") 

	    def s1 = new MemberCustomer(fName:"GiiZBrelliEN",mName:"Meteora",lName:"Hybrid",
	       	gender:"Mail",born:"2000/12/1",age:"19",nationality:"Thai",
	       	idCityzen:"12345678909876",address:"Nakhonratchima",
	       	emailAddress:"giizbrellien@gmail.com",memberId:"UltimateBoss",
	       	memberType:"VIP MEMBER",telNo:"0882329929")

	    def s2 = new MemberCustomer(fName:"GiiZBrelliEN",mName:"Meteora",lName:"Hybrid",
	       	gender:"Mail",born:"2000/12/1",age:"19",nationality:"Thai",
	       	idCityzen:"123456789098",address:"Nakhonratchima",
	       	emailAddress:"giizbrellien@gmail.com",memberId:"UltimateBoss",
	       	memberType:"VIP MEMBER",telNo:"0882329929")
	    assert s.validate() == false
	    assert s1.validate() == false
	    assert s2.validate() == false    	

    }
    void testUnique(){
    	def s = new MemberCustomer(fName:"GiiZBrelliEN",mName:"Meteora",lName:"Hybrid",
	       	gender:"Mail",born:"2000/12/1",age:"19",nationality:"Thai",
	       	idCityzen:"123456789098",address:"Nakhonratchima",
	       	emailAddress:"giizbrellien@gmail.com",memberId:"UltimateBoss",
	       	memberType:"VIP MEMBER",telNo:"0882329929").save()

    	def s1 = new MemberCustomer(fName:"GiiZBrelliEN",mName:"Meteora",lName:"Hybrid",
	       	gender:"Mail",born:"2000/12/1",age:"19",nationality:"Thai",
	       	idCityzen:"123456789098",address:"Nakhonratchima",
	       	emailAddress:"giizbrellien@gmail.com",memberId:"UltimateBoss",
	       	memberType:"VIP MEMBER",telNo:"0882329929")

    	assert s1.validate() == false 

    }
}
