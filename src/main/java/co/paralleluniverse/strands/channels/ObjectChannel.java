/*
 * Quasar: lightweight threads and actors for the JVM.
 * Copyright (C) 2013, Parallel Universe Software Co. All rights reserved.
 * 
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *  
 *   or (per the licensee's choosing)
 *  
 * under the terms of the GNU Lesser General Public License version 3.0
 * as published by the Free Software Foundation.
 */
package co.paralleluniverse.strands.channels;

import co.paralleluniverse.strands.queues.SingleConsumerArrayObjectQueue;
import co.paralleluniverse.strands.queues.SingleConsumerLinkedArrayObjectQueue;
import co.paralleluniverse.strands.queues.SingleConsumerQueue;

/**
 *
 * @author pron
 */
public class ObjectChannel<Message> extends Channel<Message> {
    public static <Message> ObjectChannel<Message> create(Object owner, int mailboxSize) {
        return new ObjectChannel(owner, mailboxSize > 0 ? new SingleConsumerArrayObjectQueue<Message>(mailboxSize) : new SingleConsumerLinkedArrayObjectQueue<Message>());
    }

    public static <Message> ObjectChannel<Message> create(int mailboxSize) {
        return new ObjectChannel(mailboxSize > 0 ? new SingleConsumerArrayObjectQueue<Message>(mailboxSize) : new SingleConsumerLinkedArrayObjectQueue<Message>());
    }

    private ObjectChannel(Object owner, SingleConsumerQueue<Message, ?> queue) {
        super(owner, queue);
    }

    private ObjectChannel(SingleConsumerQueue<Message, ?> queue) {
        super(queue);
    }
}
