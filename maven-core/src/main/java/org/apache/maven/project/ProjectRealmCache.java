package org.apache.maven.project;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.List;

import org.apache.maven.artifact.resolver.filter.ArtifactFilter;
import org.codehaus.plexus.classworlds.realm.ClassRealm;

/**
 * Caches project class realms. <strong>Warning:</strong> This is an internal utility interface that is only public for
 * technical reasons, it is not part of the public API. In particular, this interface can be changed or deleted without
 * prior notice.
 * 
 * @author Igor Fedorenko
 * @author Benjamin Bentmann
 */
public interface ProjectRealmCache
{

    public static class CacheRecord
    {

        public final ClassRealm realm;

        public final ArtifactFilter extensionArtifactFilter;

        public CacheRecord( ClassRealm realm, ArtifactFilter extensionArtifactFilter )
        {
            this.realm = realm;
            this.extensionArtifactFilter = extensionArtifactFilter;
        }

    }

    CacheRecord get( List<? extends ClassRealm> extensionRealms );

    void put( List<? extends ClassRealm> extensionRealms, ClassRealm projectRealm,
              ArtifactFilter extensionArtifactFilter );

    void flush();

}
