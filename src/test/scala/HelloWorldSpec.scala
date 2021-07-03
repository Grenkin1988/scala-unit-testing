import org.scalatest.flatspec.AnyFlatSpec

class HelloWorldSpec extends AnyFlatSpec {
    behavior of "Hello world"

    it should "start with 'Hello'" in {
        assert("Hello World".startsWith("Hello"))
    }
}
