package mocking

import matchers.UnitSpec
import com.h2.services.Currency
import org.scalamock.scalatest.MockFactory

class FunctionMockSpec extends UnitSpec with MockFactory {
    behavior of "Currency's Mocking"

    it should "be able to mock a higher-order function for any input argument and anyNumberOfTimes" in {
        val currencies: List[Currency] = List("100 USD", "20 EUR", "1000 CAD", "1 USD")

        def getCurrency(criteria: Currency => Boolean) = currencies.filter(criteria)

        val mocked = mockFunction[Currency, Boolean]
        mocked.expects(*).anyNumberOfTimes()

        getCurrency(mocked)
    }
}
