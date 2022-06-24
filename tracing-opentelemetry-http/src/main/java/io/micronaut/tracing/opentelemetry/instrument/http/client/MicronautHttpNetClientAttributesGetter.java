/*
 * Copyright 2017-2022 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.tracing.opentelemetry.instrument.http.client;

import io.micronaut.core.annotation.Internal;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.opentelemetry.instrumentation.api.instrumenter.net.InetSocketAddressNetClientAttributesGetter;

import javax.annotation.Nullable;
import java.net.InetSocketAddress;

import static io.opentelemetry.semconv.trace.attributes.SemanticAttributes.NetTransportValues.IP_TCP;

@Internal
final class MicronautHttpNetClientAttributesGetter
    extends InetSocketAddressNetClientAttributesGetter<MutableHttpRequest<Object>, HttpResponse<Object>> {

    @Override
    public InetSocketAddress getAddress(MutableHttpRequest<Object> request,
                                        @Nullable HttpResponse<Object> response) {
        return request.getRemoteAddress();
    }

    @Override
    public String transport(MutableHttpRequest<Object> request,
                            @Nullable HttpResponse<Object> response) {
        return IP_TCP;
    }
}