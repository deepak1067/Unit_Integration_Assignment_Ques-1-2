package CheckEmail

import org.scalatest.funsuite.AnyFunSuite

class CheckEmailTest extends AnyFunSuite{

  val email = new CheckEmail
  test("Check Recepient's Name that it doesnot contain special characters"){

    val expectedValue = true
    val result = email.recipientName("ds772084@gmail.com")
    assert(result == expectedValue)
  }

  test("Recepient's Name with Special Characters throw Illegal Argument Exception"){

    intercept[IllegalArgumentException]{
      email.recipientName("ds77223??@gmail.com")
    }
  }


  test("Check '@' Symbol is present in the Email ID"){

    val expectedValue= true
    val result = email.checkAtTheRate("ds772084@gmail.com")
    assert(result == expectedValue)
  }


  test("Email ID without '@' throws Illegal Argument Exception"){

    intercept[IllegalArgumentException]{
      email.checkAtTheRate("deepakknoldus.com")
    }
  }


  test("Check that Domain Name does not contain special characters"){

    val expectedValue= true
    val result = email.domainName("ds772084@gmail.com")
    assert(result == expectedValue)
  }


  test("Domain Name with Special Characters throws Illegal Argument Exception"){

    intercept[IllegalArgumentException]{
      email.domainName("deepak@knoldus#23.com")
    }
  }


  test("Check Top Level Domains are .com/.net/.org"){

    val expectedValue= true
    val result = email.topLevelDomain("ds772084@gmail.com")
    assert(result == expectedValue)
  }

  test("If Top Level Domain is not .net/.org/.com it throws Illegal Argument Exception"){

    intercept[IllegalArgumentException]{
      email.topLevelDomain("deepak@knoldus.co.in")
    }
  }
}
