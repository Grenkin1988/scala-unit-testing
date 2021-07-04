package assertions

import org.scalatest.flatspec.AnyFlatSpec
import com.h2.entities.Email
import com.h2.entities.Dollars

class EmailSpec extends AnyFlatSpec {
    behavior of "An Email"

    it should "return an Email for valid String" in {
        val email = Email("howdy@google.com")

        assert(email.localPart === "howdy")
        assert(email.domain === "google.com")
    }

    it should "return another Email object for another valid String" in {
        assertResult("jim") {
            Email("jim@google.com").localPart
        }
    }

    it should "throw an exception when email does not contain '@' symbol" in {
        withClue("Expected exception IllegalArgumentException"){
            assertThrows[IllegalArgumentException] {
                Email("jim.com")
            }
        }
    }

    it should "throw an exception when email contains more then one '@' symbol" in {
        assertThrows[IllegalArgumentException] {
            Email("jim@google@.com")
        }
    }

    it should "intercept the correct error message when no '@' symbol is provided" in {
        val exception = intercept[IllegalArgumentException] {
            Email("jimgoogle.com")
        }
        assert(exception.isInstanceOf[IllegalArgumentException])
        assert(exception.getMessage.contains("does not contain '@'"))
    }

    it should "intercept the correct error message when more then one '@' symbol is provided" in {
        val exception = intercept[IllegalArgumentException] {
            Email("jim@google@.com")
        }
        assert(exception.isInstanceOf[IllegalArgumentException])
        assert(exception.getMessage.contains("should not contain '@' symbol more than once"))
    }
}
