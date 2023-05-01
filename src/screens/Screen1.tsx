import React, {useEffect} from 'react';

import NativeMigrationModule from 'MigrationModule/js/NativeMigrationModule';

export default function Screen1() {
  useEffect(() => {
    NativeMigrationModule?.navigate('1');
  }, []);

  return <></>;
}
