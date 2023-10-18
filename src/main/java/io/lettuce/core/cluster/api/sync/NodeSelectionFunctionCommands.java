/*
 * Copyright 2017-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lettuce.core.cluster.api.sync;

import java.util.List;
import java.util.Map;

import io.lettuce.core.FlushMode;
import io.lettuce.core.FunctionRestoreMode;
import io.lettuce.core.ScriptOutputType;

/**
 * Synchronous executed commands on a node selection for Redis Functions. {@link java.lang.String Function code} is encoded by
 * using the configured {@link io.lettuce.core.ClientOptions#getScriptCharset() charset}.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 6.3
 * @generated by io.lettuce.apigenerator.CreateSyncNodeSelectionClusterApi
 */
public interface NodeSelectionFunctionCommands<K, V> {

    /**
     * Invoke a function.
     *
     * @param function the function name.
     * @param type output type.
     * @param keys key names.
     * @param <T> expected return type.
     * @return function result.
     */
    <T> Executions<T> fcall(String function, ScriptOutputType type, K... keys);

    /**
     * Invoke a function.
     *
     * @param function the function name.
     * @param type output type.
     * @param keys the keys.
     * @param values the values (arguments).
     * @param <T> expected return type.
     * @return function result.
     */
    <T> Executions<T> fcall(String function, ScriptOutputType type, K[] keys, V... values);

    /**
     * Invoke a function in read-only mode.
     *
     * @param function the function name.
     * @param type output type.
     * @param keys key names.
     * @param <T> expected return type.
     * @return function result.
     */
    <T> Executions<T> fcallReadOnly(String function, ScriptOutputType type, K... keys);

    /**
     * Invoke a function in read-only mode.
     *
     * @param function the function name.
     * @param type output type.
     * @param keys the keys.
     * @param values the values (arguments).
     * @param <T> expected return type.
     * @return function result.
     */
    <T> Executions<T> fcallReadOnly(String function, ScriptOutputType type, K[] keys, V... values);

    /**
     * Load a library to Redis.
     *
     * @param functionCode code of the function.
     * @return name of the library.
     */
    Executions<String> functionLoad(String functionCode);

    /**
     * Load a library to Redis.
     *
     * @param functionCode code of the function.
     * @param replace whether to replace an existing function.
     * @return name of the library.
     */
    Executions<String> functionLoad(String functionCode, boolean replace);

    /**
     * Return the serialized payload of loaded libraries. You can restore the dump through {@link #functionRestore(byte[])}.
     *
     * @return the serialized payload.
     */
    Executions<byte[]> functionDump();

    /**
     * You can restore the dumped payload of loaded libraries.
     *
     * @return Simple string reply
     */
    Executions<String> functionRestore(byte[] dump);

    /**
     * You can restore the dumped payload of loaded libraries.
     *
     * @return Simple string reply
     */
    Executions<String> functionRestore(byte[] dump, FunctionRestoreMode mode);

    /**
     * Deletes all the libraries using the specified {@link FlushMode}.
     *
     * @param flushMode the flush mode (sync/async).
     * @return String simple-string-reply.
     */
    Executions<String> functionFlush(FlushMode flushMode);

    /**
     * Kill a function that is currently executing.
     *
     * @return String simple-string-reply.
     */
    Executions<String> functionKill();

    /**
     * Return information about the functions and libraries.
     *
     * @return Array reply.
     */
    Executions<List<Map<String, Object>>> functionList();

    /**
     * Return information about the functions and libraries.
     *
     * @param libraryName specify a pattern for matching library names.
     * @return Array reply.
     */
    Executions<List<Map<String, Object>>> functionList(String libraryName);

}
