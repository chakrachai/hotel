package team08

class Room {
    MemberCustomer customer
    Employee employee
    String roomNo   //เลขห้อง
    String roomflore //ชั้น
    int customermany //จำนวนคน
    String dayIn    //วันเข้า
    String dayOut   //วันออก
    String roomStatus   //สถานะห้อง
    static constraints = {
        customer nullable:true
        employee nullable:true
        roomStatus inList:['ว่าง','จอง','ใช้งาน','ห้องชำรุด']
        customermany range:1..4, blank: false
    }
}