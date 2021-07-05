package matchers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.h2.services.Currency

class EqualitySpec extends AnyFlatSpec with Matchers {
    behavior of "Currency Equals"
    it should "match two 10 USD currencies as equal using 'should equals'" in {
        val ccy1: Currency = "10 USD"
        val ccy2: Currency = "10 USD"

        ccy1 should equal (ccy2)
    }
    it should "match two 10 USD currencies as equal using 'should ==='" in {
        val ccy1: Currency = "10 USD"
        val ccy2: Currency = "10 USD"

        ccy1 should === (ccy2)
    }
    it should "match two 10 USD currencies as equal using 'shouldEqual'" in {
        val ccy1: Currency = "10 USD"
        val ccy2: Currency = "10 USD"

        ccy1 shouldEqual ccy2
    }
    it should "match two 10 USD currencies as equal using 'shouldBe'" in {
        val ccy1: Currency = "10 USD"
        val ccy2: Currency = "10 USD"

        ccy1 shouldBe ccy2
    }
    it should "match two 10 USD currencies as equal using 'should be'" in {
        val ccy1: Currency = "10 USD"
        val ccy2: Currency = "10 USD"

        ccy1 should be (ccy2)
    }
}
