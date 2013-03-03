package team08

class Room {
	MemberCustomer customer
	Employee employee
	String roomNo	//เลขห้อง
	String roomflore //ชั้น
	String customermany //จำนวนคน
	String dayIn	//วันเข้า
	String dayOut	//วันออก
	String roomStatus	//สถานะห้อง
    static constraints = {
		customer  nullable:true
		employee  nullable:true
		roomNo nullable:true
		roomflore nullable:true
		customermany nullable:true
		dayIn nullable:true
		dayOut nullable:true
		roomStatus nullable:true
    }
}