package team08



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(MakeEventCustomer)
class MakeEventCustomerTests {

    void testEventCustomer() {
       
        def p1 = new MemberCustomer(fName:"Customer1",mName:"",lName:"LCustomer1",gender:"M",born:"Thai",age:"35",nationality:"Thai",idCityzen:"1111111111111",address:"OnTheRoad",emailAddress:"aaa@a.com",memberId:"C1234",memberType:"VIP",telNo:"0000000")
    	def re = new MakeEventCustomer(customerc:p1,pricerec:"200000",daterec:"23/3/2013",dateresendc:"20/3/2013")
    	assert re.validate() == true
    }
}
