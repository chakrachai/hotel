package team08



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Room)
class RoomTests {

	void testRoom() {

    	def p1 = new MemberCustomer(fName:"Customer1",mName:"",lName:"LCustomer1",gender:"M",born:"Thai",age:"35",nationality:"Thai",idCityzen:"1111111111111",address:"OnTheRoad",emailAddress:"aaa@a.com",memberId:"C1234",memberType:"VIP",telNo:"0000000")
		def e1 = new Employee(nameem:"Employee 1",classem:"Cashier",idem:"E1234",statusem:"อยู่",lnameem:"LEmployee1",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"21234",sexem:"male",nation:"THAI",irreligious:"พุทธ")
    	def r = new Room(customer:p1,employee:e1,roomNo:"1001",roomflore:"2",customermany:"3",dayIn:"10082556",dayOut:"11082556",roomStatus:"ว่าง")
    	assert r.validate() == true
    }
    void testCustomer() {

    	def p1 = new MemberCustomer(fName:"Customer1",mName:"",lName:"LCustomer1",gender:"M",born:"Thai",age:"35",nationality:"Thai",idCityzen:"1111111111111",address:"OnTheRoad",emailAddress:"aaa@a.com",memberId:"C1234",memberType:"VIP",telNo:"0000000")
		def e1 = new Employee(nameem:"Employee 1",classem:"Cashier",idem:"E1234",statusem:"อยู่",lnameem:"LEmployee1",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"21234",sexem:"male",nation:"THAI",irreligious:"พุทธ")
    	def r = new Room(customer:null,employee:e1,roomNo:"1001",roomflore:"2",customermany:"3",dayIn:"10082556",dayOut:"11082556",roomStatus:"ว่าง")
    	assert r.validate() == true
    }
    void testEmployee() {

    	def p1 = new MemberCustomer(fName:"Customer1",mName:"",lName:"LCustomer1",gender:"M",born:"Thai",age:"35",nationality:"Thai",idCityzen:"1111111111111",address:"OnTheRoad",emailAddress:"aaa@a.com",memberId:"C1234",memberType:"VIP",telNo:"0000000")
		def e1 = new Employee(nameem:"Employee 1",classem:"Cashier",idem:"E1234",statusem:"อยู่",lnameem:"LEmployee1",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"21234",sexem:"male",nation:"THAI",irreligious:"พุทธ")
    	def r = new Room(customer:p1,employee:null,roomNo:"1001",roomflore:"2",customermany:"3",dayIn:"10082556",dayOut:"11082556",roomStatus:"ว่าง")
    	assert r.validate() == true
    }
    void teststatus() {

    	def p1 = new MemberCustomer(fName:"Customer1",mName:"",lName:"LCustomer1",gender:"M",born:"Thai",age:"35",nationality:"Thai",idCityzen:"1111111111111",address:"OnTheRoad",emailAddress:"aaa@a.com",memberId:"C1234",memberType:"VIP",telNo:"0000000")
		def e1 = new Employee(nameem:"Employee 1",classem:"Cashier",idem:"E1234",statusem:"อยู่",lnameem:"LEmployee1",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"21234",sexem:"male",nation:"THAI",irreligious:"พุทธ")
    	def r = new Room(customer:p1,employee:e1,roomNo:"1001",roomflore:"1",customermany:"3",dayIn:"10082556",dayOut:"11082556",roomStatus:"ลืม")
    	assert r.validate() == false
    }
    void testCustomermany() {

    	def p1 = new MemberCustomer(fName:"Customer1",mName:"",lName:"LCustomer1",gender:"M",born:"Thai",age:"35",nationality:"Thai",idCityzen:"1111111111111",address:"OnTheRoad",emailAddress:"aaa@a.com",memberId:"C1234",memberType:"VIP",telNo:"0000000")
		def e1 = new Employee(nameem:"Employee 1",classem:"Cashier",idem:"E1234",statusem:"อยู่",lnameem:"LEmployee1",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"21234",sexem:"male",nation:"THAI",irreligious:"พุทธ")
    	def r = new Room(customer:p1,employee:e1,roomNo:"1001",roomflore:"1",customermany:"100",dayIn:"10082556",dayOut:"11082556",roomStatus:"ว่าง")
    	assert r.validate() == false
    }
}
