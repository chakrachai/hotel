package team08
class MemberCustomer {

	String fName			//ชื่อลูกค้า
	String mName			//ชื่อกลาง
	String lName			//นามสกุล
	String gender			//เพศสภาพ
	String born				//วันเกิด
	String age				//อายุ
	String nationality		//สัญชาติ
	String idCityzen		//รหัสประจำตัวประชาชน
	String address			//ที่อยู่ตามทะเบียนบ้าน
	String emailAddress		//อีเมลล์ที่ติดต่อได้
	String memberId			//รหัสลูกค้า
	String memberType		//ประเภทลูกค้า[normal,VIP]


    static constraints = {
    	mName nullable:true  //อนุญาติให้เป็นค่า ืีnull
    }
}