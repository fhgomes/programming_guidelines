internal class Service {
	fun method_1_using_if(){
		val result = OtherService().doSome()

		if (result != "OK") {
			throw RuntimeException("Falha executar. Com texto longo aqui que vai indo até chegar numa quebra de página " +
				"porque é muito longo mesmo")
		}

		println("Executado com sucesso. Com texto longo aqui que vai indo até chegar numa quebra de página " +
			"porque é muito longo mesmo")

	}

	fun method_2_using_takeif() {
		OtherService().doSome()
			.takeIf { result -> result != "OK" }?.apply {
				println("Executado com sucesso. Com texto longo aqui que vai indo até chegar numa quebra de página " +
					"porque é muito longo mesmo")
			} ?: throw RuntimeException("Falha executar. Com texto longo aqui que vai indo até chegar numa quebra de página " +
			"porque é muito longo mesmo")
	}
}

internal class OtherService {
	fun doSome(): String {
		return "OK"
	}
}
