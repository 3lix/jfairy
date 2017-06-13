package io.codearte.jfairy.producer.person.locale.de

import io.codearte.jfairy.producer.BaseProducer
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Roland Weisleder
 */
class DeNationalIdentityCardNumberProviderSpec extends Specification {

	private BaseProducer baseProducer = new BaseProducer(new Random())
	private DeNationalIdentityCardNumberProvider generator = new DeNationalIdentityCardNumberProvider(baseProducer)

	@Unroll
	def "Should validate #nationalIdentityCardNumber as #valid"() {
		expect:
			generator.isValid(nationalIdentityCardNumber) == valid
		where:
			nationalIdentityCardNumber | valid
			'T22000129'                | true
			'123456789'                | false
			'L00000000'                | true
			'A12345678'                | false
	}

	def "Should always generate proper nationalIdentityCardNumber"() {
		expect:
			generator.isValid(generator.get())
		where:
			i << (1..100)
	}

}
