----------------------------------------------------------------------
--  Disk Profiles
----------------------------------------------------------------------

Create or replace FUNCTION GetDiskProfileByDiskProfileId(v_id UUID)
RETURNS SETOF disk_profiles STABLE
   AS $procedure$
BEGIN

   RETURN QUERY SELECT *
   FROM disk_profiles
   WHERE id = v_id;

END; $procedure$
LANGUAGE plpgsql;


Create or replace FUNCTION InsertDiskProfile(v_id UUID,
  v_name VARCHAR(50),
  v_storage_domain_id UUID,
  v_qos_id UUID,
  v_description TEXT)
RETURNS VOID
   AS $procedure$
BEGIN

   INSERT INTO disk_profiles(id, name, storage_domain_id, qos_id, description)
       VALUES(v_id, v_name, v_storage_domain_id, v_qos_id, v_description);

END; $procedure$
LANGUAGE plpgsql;


Create or replace FUNCTION UpdateDiskProfile(v_id UUID,
  v_name VARCHAR(50),
  v_storage_domain_id UUID,
  v_qos_id UUID,
  v_description TEXT)
RETURNS VOID
   AS $procedure$
BEGIN

   UPDATE disk_profiles
   SET id = v_id, name = v_name, storage_domain_id = v_storage_domain_id, qos_id = v_qos_id,
       description = v_description, _update_date = LOCALTIMESTAMP
   WHERE id = v_id;

END; $procedure$
LANGUAGE plpgsql;


Create or replace FUNCTION DeleteDiskProfile(v_id UUID)
RETURNS VOID
   AS $procedure$
   DECLARE
   v_val UUID;
BEGIN

    DELETE FROM disk_profiles
    WHERE id = v_id;

    -- Delete the disk profiles permissions
    DELETE FROM permissions WHERE object_id = v_id;

END; $procedure$
LANGUAGE plpgsql;


Create or replace FUNCTION GetAllFromDiskProfiles()
RETURNS SETOF disk_profiles STABLE
   AS $procedure$
BEGIN

   RETURN QUERY SELECT *
   FROM disk_profiles;

END; $procedure$
LANGUAGE plpgsql;


Create or replace FUNCTION GetDiskProfilesByStorageDomainId(v_storage_domain_id UUID)
RETURNS SETOF disk_profiles STABLE
   AS $procedure$
BEGIN

   RETURN QUERY SELECT *
   FROM disk_profiles
   WHERE storage_domain_id = v_storage_domain_id;

END; $procedure$
LANGUAGE plpgsql;

