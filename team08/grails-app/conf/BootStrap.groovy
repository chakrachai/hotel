import team08.*

class BootStrap {

    def init = { servletContext ->

    	def p1 = new MemberCustomer(fName:"Customer1",mName:"",lName:"LCustomer1",gender:"M",born:"Thai",age:"35",nationality:"Thai",idCityzen:"1111111111111",address:"OnTheRoad",emailAddress:"aaa@a.com",memberId:"C1234",memberType:"VIP").save()

		def e1 = new Employee(nameem:"Employee1",classem:"serviceCustomer",idem:"E1234",statusem:"I Don't No",lnameem:"LEmployee",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30").save()

		def re1 = new MakeEvent(employee:"Employee1",customer:"Customer1",typere:"Wedding Room",idre:"Mk001",pricere:"250000",statusre:"ON")
    }
    def destroy = {
    }
}
