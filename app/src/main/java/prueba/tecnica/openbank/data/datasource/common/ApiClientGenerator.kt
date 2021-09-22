package prueba.tecnica.openbank.data.datasource.common

interface ApiClientGenerator {
    fun <T> generatedApi(service: Class<T>): T
}