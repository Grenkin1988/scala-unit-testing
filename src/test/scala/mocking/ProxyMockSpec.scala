package mocking

import matchers.UnitSpec
import org.scalamock.scalatest.MockFactory
import com.h2.services.AccountService
import java.util.UUID
import com.h2.entities.Dollars

class ProxyMockSpec extends UnitSpec with MockFactory {
    behavior of "AccountService with mocks"

    it should "mock a Trait" in {
        val mocked = mock[AccountService]

        val customerId = UUID.randomUUID()
        val productId = UUID.randomUUID()
        val tenDollars = Dollars(10)

        (mocked.openDepositAccount _) expects(customerId, productId, tenDollars)

        mocked.openDepositAccount(customerId, productId, tenDollars)
    }

    it should "return a mocked value" in {
        val mocked = mock[AccountService]

        val customerId = UUID.randomUUID()
        val productId = UUID.randomUUID()
        val accountId = UUID.randomUUID()
        val tenDollars = Dollars(10)

        (mocked.openDepositAccount _) expects(customerId, productId, tenDollars) returning accountId

        mocked.openDepositAccount(customerId, productId, tenDollars) should be (accountId)
    }
}
