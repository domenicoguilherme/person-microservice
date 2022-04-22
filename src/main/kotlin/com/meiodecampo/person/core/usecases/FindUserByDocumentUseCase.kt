package com.meiodecampo.person.core.usecases

import com.meiodecampo.person.core.ports.`in`.FindUserByDocumentInputPort
import com.meiodecampo.person.core.ports.out.FindUserByDocumentOutputPort

class FindUserByDocumentUseCase(private val findUserByDocumentOutputPort: FindUserByDocumentOutputPort): FindUserByDocumentInputPort {
    override fun handle(document: String) = findUserByDocumentOutputPort.getByDocument(document)
}