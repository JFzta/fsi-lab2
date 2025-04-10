package com.udea.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class AsientoAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAsientoAllPropertiesEquals(Asiento expected, Asiento actual) {
        assertAsientoAutoGeneratedPropertiesEquals(expected, actual);
        assertAsientoAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAsientoAllUpdatablePropertiesEquals(Asiento expected, Asiento actual) {
        assertAsientoUpdatableFieldsEquals(expected, actual);
        assertAsientoUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAsientoAutoGeneratedPropertiesEquals(Asiento expected, Asiento actual) {
        assertThat(actual)
            .as("Verify Asiento auto generated properties")
            .satisfies(a -> assertThat(a.getId()).as("check id").isEqualTo(expected.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAsientoUpdatableFieldsEquals(Asiento expected, Asiento actual) {
        assertThat(actual)
            .as("Verify Asiento relevant properties")
            .satisfies(a -> assertThat(a.getNumero()).as("check numero").isEqualTo(expected.getNumero()))
            .satisfies(a -> assertThat(a.getClase()).as("check clase").isEqualTo(expected.getClase()))
            .satisfies(a -> assertThat(a.getDisponible()).as("check disponible").isEqualTo(expected.getDisponible()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAsientoUpdatableRelationshipsEquals(Asiento expected, Asiento actual) {
        // empty method
    }
}
