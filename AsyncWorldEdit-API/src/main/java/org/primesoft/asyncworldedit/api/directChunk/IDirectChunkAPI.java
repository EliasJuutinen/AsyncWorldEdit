/*
 * AsyncWorldEdit API
 * Copyright (c) 2015, SBPrime <https://github.com/SBPrime/>
 * Copyright (c) AsyncWorldEdit API contributors
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted free of charge provided that the following 
 * conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution,
 * 3. Redistributions of source code, with or without modification, in any form 
 *    other then free of charge is not allowed,
 * 4. Redistributions in binary form in any form other then free of charge is 
 *    not allowed.
 * 5. Any derived work based on or containing parts of this software must reproduce 
 *    the above copyright notice, this list of conditions and the following 
 *    disclaimer in the documentation and/or other materials provided with the 
 *    derived work.
 * 6. The original author of the software is allowed to change the license 
 *    terms or the entire license of the software as he sees fit.
 * 7. The original author of the software is allowed to sublicense the software 
 *    or its parts using any license terms he sees fit.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.primesoft.asyncworldedit.api.directChunk;

import com.sk89q.jnbt.CompoundTag;
import com.sk89q.worldedit.math.Vector3;
import com.sk89q.worldedit.registry.state.Property;
import com.sk89q.worldedit.world.block.BlockStateHolder;
import java.util.Map;
import java.util.UUID;
import org.primesoft.asyncworldedit.api.IChunk;
import org.primesoft.asyncworldedit.api.playerManager.IPlayerEntry;

/**
 * The direct chunk API class
 *
 * @author SBPrime
 */
public interface IDirectChunkAPI {

    /**
     * Wrap bukkit chunk into direct chunk api
     *
     * @param chunk
     * @param player
     * @return
     */
    IWrappedChunk wrapChunk(IChunk chunk, IPlayerEntry player);
    
    /**
     * Wrap bukkit chunk into direct chunk api
     *
     * @param chunk
     * @return
     */
    IWrappedChunk wrapChunk(IChunk chunk);

    /**
     * Create an empty chunk data
     *
     * @return
     */
    IChunkData createChunkData();

    /**
     * Create an lazy chunk data
     *
     * @param chunk
     * @return
     */
    IChangesetChunkData createLazyChunkData(IWrappedChunk chunk);

    /**
     * Converts material and data to chunk section id
     *
     * @param m
     * @param data
     * @return
     */
    int getCombinedId(BlockStateHolder m, Map<Property<?>, Object> data);

    /**
     * Converts type and data to chunk section id
     *
     * @param type
     * @param data
     * @return
     */
    int getCombinedId(String type, Map<Property<?>, Object> data);

    /**
     * Get material
     * @param type
     * @return 
     */
    String getMaterial(int type);
    
    /**
     * Get WorldEdit base blocks
     *
     * @param type
     * @param nbt
     * @return
     */
    BlockStateHolder getBaseBlock(int type, CompoundTag nbt);

    /**
     * Convert combined ID to Material and data
     *
     * @param combinedId
     * @return
     */
    BlockStateHolder convertId(int combinedId);

    /**
     * Create new instance of serialized entity
     *
     * @param uuid
     * @param position
     * @param yaw
     * @param pitch
     * @param nbt
     * @return
     */
    ISerializedEntity createEntity(UUID uuid, Vector3 position,
            float yaw, float pitch, byte[] nbt);

    /**
     * Return the material light emission level
     *
     * @param type
     * @param data
     * @return
     */
    byte getLightEmissionLevel(String type, Map<Property<?>, Object> data);

    /**
     * Return the material light emission level
     *
     * @param block
     * @return
     */
    byte getLightEmissionLevel(BlockStateHolder block);

    /**
     * Return the material light emission level
     *
     * @param id
     * @return
     */
    byte getLightEmissionLevel(int id);

    /**
     * Get the material opacity level (how much it obscures light)
     *
     * @param type
     * @param data
     * @return
     */
    short getOpacityLevel(String type, Map<Property<?>, Object> data);

    /**
     * Get the material opacity level (how much it obscures light)
     *
     * @param block
     * @return
     */
    short getOpacityLevel(BlockStateHolder block);

    /**
     * Get the material opacity level (how much it obscures light)
     *
     * @param id
     * @return
     */
    short getOpacityLevel(int id);
    
    
    /**
     * Get the material opacity level (how much it obscures light)
     * for skylight
     *
     * @param type
     * @param data
     * @return
     */
    short getOpacityLevelSkyLight(String type, Map<Property<?>, Object> data);

    /**
     * Get the material opacity level (how much it obscures light)
     * for skylight
     *
     * @param block
     * @return
     */
    short getOpacityLevelSkyLight(BlockStateHolder block);

    /**
     * Get the material opacity level (how much it obscures light)
     * for skylight
     *
     * @param id
     * @return
     */
    short getOpacityLevelSkyLight(int id);
}
