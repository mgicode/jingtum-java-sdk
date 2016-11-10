/**
 * Copyright@2016 Jingtum Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jingtum.sdk.core.bouncycastle.asn1;

import java.io.IOException;

/**
 * A NULL object.
 */
public abstract class ASN1Null
    extends ASN1Primitive
{
    /**
     * @deprecated use DERNull.INSTANCE
     */
    public ASN1Null()
    {
    }

    public static ASN1Null getInstance(Object o)
    {
        if (o instanceof ASN1Null)
        {
            return (ASN1Null)o;
        }

        if (o != null)
        {
            try
            {
                return ASN1Null.getInstance(ASN1Primitive.fromByteArray((byte[])o));
            }
            catch (IOException e)
            {
                throw new IllegalArgumentException("failed to construct NULL from byte[]: " + e.getMessage());
            }
            catch (ClassCastException e)
            {
                throw new IllegalArgumentException("unknown object in getInstance(): " + o.getClass().getName());
            }
        }

        return null;
    }

    public int hashCode()
    {
        return -1;
    }

    boolean asn1Equals(
        ASN1Primitive o)
    {
        if (!(o instanceof ASN1Null))
        {
            return false;
        }
        
        return true;
    }

    abstract void encode(ASN1OutputStream out)
        throws IOException;

    public String toString()
    {
         return "NULL";
    }
}
