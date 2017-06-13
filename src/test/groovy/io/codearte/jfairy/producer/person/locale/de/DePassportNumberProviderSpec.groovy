package io.codearte.jfairy.producer.person.locale.de

import io.codearte.jfairy.producer.BaseProducer
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Roland Weisleder
 */
class DePassportNumberProviderSpec extends Specification {

	private BaseProducer baseProducer = new BaseProducer(new Random())
	private DePassportNumberProvider generator = new DePassportNumberProvider(baseProducer)

	@Unroll
	def "Should validate #passportNumber as #valid"() {
		expect:
			generator.isValid(passportNumber) == valid
		where:
			passportNumber | valid
			'C22000129'    | true
			'123456789'    | false
			'H00000000'    | true
			'A12345678'    | false
	}

	def "Should always generate proper passportNumber"() {
		expect:
			generator.isValid(generator.get())
		where:
			i << (1..100)
	}

}
