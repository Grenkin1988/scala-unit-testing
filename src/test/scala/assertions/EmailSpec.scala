package assertions

import org.scalatest.flatspec.AnyFlatSpec
import com.h2.entities.Email

class EmailSpec extends AnyFlatSpec {
    behavior of "An Email"

    it should "return an Email for valid String" in {
        val email = Email("howdy@google.com")

        assert(email.localPart === "howdy")
        assert(email.domain === "google.com")
    }
}
