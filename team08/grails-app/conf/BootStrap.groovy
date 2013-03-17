import team08.*

class BootStrap {

    def init = { servletContext ->

    	def p1 = new MemberCustomer(fName:"GiiZBrelliEN",mName:"Meteora",lName:"Hybrid",gender:"Mail",born:"2000/12/1",age:"19",nationality:"Thai",idCityzen:"1109900784877",address:"Nakhonratchima",emailAddress:"giizbrellien@gmail.com",memberId:"UltimateBoss",memberType:"VIP MEMBER",telNo:"0882329929").save()
    	def p2 = new MemberCustomer(fName:"GiiZBrelliEN",mName:"Meteora",lName:"Hybrid",gender:"Mail",born:"2000/12/1",age:"19",nationality:"Thai",idCityzen:"1234567890123",address:"Nakhonratchima",emailAddress:"giizbrellien@gmail.com",memberId:"C1234",memberType:"VIP MEMBER",telNo:"0882329929").save()

		def e1 = new Employee(nameem:"Employee 1",classem:"Cashier",idem:"E1234",statusem:"อยู่",lnameem:"LEmployee1",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"21234",sexem:"male",nation:"THAI",irreligious:"พุทธ").save()
		def e2 = new Employee(nameem:"Employee 2",classem:"Head Housekeeper",idem:"E3422",statusem:"ไม่อยู่",lnameem:"LEmployee2",tel:"02005330",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"42134213",sexem:"male",nation:"CHINA",irreligious:"พุทธ").save()
		def e3 = new Employee(nameem:"Employee 3",classem:"serviceCustomer",idem:"E1323",statusem:"อยู่",lnameem:"LEmployee3",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"2314123",sexem:"female",nation:"THAI",irreligious:"พุทธ").save()
		def e4 = new Employee(nameem:"Employee 4",classem:"Reception",idem:"E4325",statusem:"อยู่",lnameem:"LEmployee4",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"1421424124",sexem:"male",nation:"THAI",irreligious:"พุทธ").save()
		def e5 = new Employee(nameem:"Employee 5",classem:"Concierge",idem:"E3334",statusem:"อยู่",lnameem:"LEmployee5",tel:"020000000",address:"Ho",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"3213124",sexem:"female",nation:"THAI",irreligious:"พุทธ").save()
		def e6 = new Employee(nameem:"Employee 6",classem:"serviceCustomer",idem:"E1232",statusem:"ไม่อยู่",lnameem:"LEmployee6",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"3214124",sexem:"male",nation:"CHINA",irreligious:"พุทธ").save()
		def e7 = new Employee(nameem:"Employee 7",classem:"Hall Porter",idem:"E8556",statusem:"ไม่อยู่",lnameem:"LEmployee7",tel:"020000000",address:"Ho",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"4124124",sexem:"male",nation:"THAI",irreligious:"พุทธ").save()
		def e8 = new Employee(nameem:"Employee 8",classem:"Concierge",idem:"E4632",statusem:"อยู่",lnameem:"LEmployee8",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"142412",sexem:"female",nation:"THAI",irreligious:"พุทธ").save()
		def e9 = new Employee(nameem:"Employee 9",classem:"Security",idem:"E9444",statusem:"อยู่",lnameem:"LEmployee9",tel:"020000000",address:"Ho",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"21312312",sexem:"female",nation:"CHINA",irreligious:"พุทธ").save()
		def e10 = new Employee(nameem:"Employee10",classem:"Security",idem:"E3742",statusem:"ไม่อยู่",lnameem:"LEmployee10",tel:"020000000",address:"Ho",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"412412",sexem:"male",nation:"THAI",irreligious:"พุทธ").save()
		def e11 = new Employee(nameem:"Employee11",classem:"Doorman",idem:"E9462",statusem:"อยู่",lnameem:"LEmployee11",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"124124",sexem:"male",nation:"",irreligious:"พุทธ").save()
		def e12 = new Employee(nameem:"Employee12",classem:"Housekeeper",idem:"E0564",statusem:"อยู่",lnameem:"LEmployee12",tel:"020000000",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game",birthday:"14124",sexem:"male",nation:"THAI",irreligious:"พุทธ").save()
		def e13 = new Employee(nameem:"Micle",classem:"CEO",idem:"S1234",statusem:"อยู่",lnameem:"Sjuw",tel:"0202121500",address:"Home",numaddress:"111",district:"Mairu",subdistrict:"lum",province:"Nakhonratchima",nprovince:"3000000",idppem:"1111111111",ageem:"30",passem:"12234",nickname:"game2",birthday:"14124",sexem:"male",nation:"THAI",irreligious:"พุทธ").save()

		def ee1 = new TimeWork(employee:e1,timein:"8.30",timeout:"-").save()
		def ee2 = new TimeWork(employee:e2,timein:"9.30",timeout:"-").save()
		def ee3 = new TimeWork(employee:e3,timein:"8.20",timeout:"-").save()
		def ee4 = new TimeWork(employee:e4,timein:"8.25",timeout:"-").save()
		def ee5 = new TimeWork(employee:e5,timein:"8.35",timeout:"-").save()
		def ee6 = new TimeWork(employee:e6,timein:"9.35",timeout:"-").save()
		def ee7 = new TimeWork(employee:e7,timein:"10.30",timeout:"-").save()
		def ee8 = new TimeWork(employee:e8,timein:"13.30",timeout:"-").save()
		def ee9 = new TimeWork(employee:e9,timein:"6.30",timeout:"-").save()
		def ee10 = new TimeWork(employee:e10,timein:"7.30",timeout:"-").save()
		def ee11 = new TimeWork(employee:e11,timein:"12.20",timeout:"-").save()
		def ee12 = new TimeWork(employee:e12,timein:"11.10",timeout:"-").save()
		def ee13 = new TimeWork(employee:e13,timein:"11.10",timeout:"-").save()

		
		def re1 = new MakeEvent(employee:e1,customer:p1,typere:"Carnival",pricere:"250000",datere:"23/3/2556").save()
		def rec1 = new MakeEventCustomer(customerc:p1,typerec:"Carnival",pricerec:"250000",daterec:"23/3/2556",dateresendc:"20/3/2556").save()
		def data1 = new DataSignIn(id:"1",datainput:"").save()
		def data2 = new DataSignIn(id:"2",datainput:"").save()
		def data3 = new DataSignIn(id:"3",datainput:"").save()
		def data4 = new DataSignIn(id:"4",datainput:"").save()
		def data5 = new DataSignIn(id:"5",datainput:"").save()
		def data6 = new DataSignIn(id:"6",datainput:"").save()
    }
    def destroy = {
    }
}
