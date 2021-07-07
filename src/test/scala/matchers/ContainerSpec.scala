package matchers

import com.h2.services.Currency

class ContainerSpec extends UnitSpec {
    behavior of "Currencies in a wallet"

    it should "contain a currency that is added to a List wallet" in {
        val oneUsd: Currency = "1 USD"
        val twoEur: Currency = "2 EUR"
        val tenCad: Currency = "10 CAD"

        val wallet = List(oneUsd, twoEur, tenCad)

        wallet should contain (oneUsd)
    }

    it should "contain a currency that is added to a Set wallet" in {
        val oneUsd: Currency = "1 USD"
        val twoEur: Currency = "2 EUR"
        val tenCad: Currency = "10 CAD"

        val wallet = Set(oneUsd, twoEur, tenCad)

        wallet should contain (oneUsd)
    }

    it should "contain a currency that is added to a Map wallet" in {
        val oneUsd: Currency = "1 USD"
        val twoEur: Currency = "2 EUR"
        val tenCad: Currency = "10 CAD"

        val wallet = Map(
            "USD" -> oneUsd, 
            "EUR" -> twoEur, 
            "CAD" -> tenCad)

        wallet should contain ("USD" -> oneUsd)
    }

    it should "contain a oneOf 1USD that is added to a Set wallet" in {
        val oneUsd: Currency = "1 USD"
        val twoEur: Currency = "2 EUR"
        val tenCad: Currency = "10 CAD"
        val hundredInr: Currency = "100 INR"

        val wallet = Set(oneUsd, oneUsd, twoEur, twoEur, tenCad, tenCad)

        wallet should contain oneOf (oneUsd, hundredInr)
        wallet should contain oneElementOf List(oneUsd, hundredInr)
    }

    it should "contain a noneOf 100 INR that is added to a Set wallet" in {
        val oneUsd: Currency = "1 USD"
        val twoEur: Currency = "2 EUR"
        val tenCad: Currency = "10 CAD"
        val hundredInr: Currency = "100 INR"

        val wallet = Set(oneUsd, oneUsd, twoEur, twoEur)

        wallet should contain noneOf (tenCad, hundredInr)
        wallet should contain noElementsOf List(tenCad, hundredInr)
    }
}
