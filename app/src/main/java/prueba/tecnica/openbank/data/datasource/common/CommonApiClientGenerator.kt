package prueba.tecnica.openbank.data.datasource.common

interface ComonApiClientGenerator : ApiClientGenerator

inline fun <reified T : Any> ComonApiClientGenerator.generateApi() = generatedApi(T::class.java)