package com.ciudadania.entity.commons

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.util.*


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class AbstractBaseAuditable : Serializable {
    /**
     * True if the record is active otherwise false
     */
    @Column(name = "is_active", columnDefinition = "tinyint default 1")
    protected var isActive: Boolean? = null

    /**
     * Date of the last modification
     */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    protected var updatedAt: Date? = null

    /**
     * Date of the last modification
     */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    protected var createdAt: Date? = null

    /**
     * User who created the record
     */
    @CreatedBy
    @Column(name = "creator_user_id", updatable = false, nullable = false)
    protected var creatorUserId: String? = null

    /**
     * User who made the last modification of the registry
     */
    @LastModifiedBy
    @Column(name = "updater_user_id")
    protected var updaterUserId: String? = null

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }
}