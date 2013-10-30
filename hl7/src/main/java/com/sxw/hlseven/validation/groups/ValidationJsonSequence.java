/**
 * 
 */
package com.sxw.hlseven.validation.groups;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
@GroupSequence({ Default.class, ValidationJsonEntityGroup.class })
public interface ValidationJsonSequence {

}
