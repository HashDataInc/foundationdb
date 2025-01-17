/*
 * KeyArrayResult.java
 *
 * This source file is part of the FoundationDB open source project
 *
 * Copyright 2013-2020 Apple Inc. and the FoundationDB project authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.apple.foundationdb;

import java.util.ArrayList;
import java.util.List;

public class KeyArrayResult {
	final List<byte[]> keys;

	KeyArrayResult(byte[] keyBytes, int[] keyLengths) {
		int count = keyLengths.length;
		keys = new ArrayList<byte[]>(count);

		int offset = 0;
		for(int i = 0; i < count; i++) {
			int keyLength = keyLengths[i];

			byte[] key = new byte[keyLength];
			System.arraycopy(keyBytes, offset, key, 0, keyLength);

			offset += keyLength;
			keys.add(key);
		}
	}
	
	public List<byte[]> getKeys() {
		return keys;	
	}
}
